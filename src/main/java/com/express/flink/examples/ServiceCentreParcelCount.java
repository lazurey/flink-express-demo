package com.express.flink.examples;

import com.express.flink.models.ScanItem;
import com.express.flink.models.ServiceCentre;
import com.express.flink.sources.MockScanData;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class ServiceCentreParcelCount {

    private final static String SEPARATOR = "\\|";
    final ServiceCentre londonCentre = new ServiceCentre("London Centre", "SE1 5SR");

    public static void main(String[] args) throws Exception {

        // 1. Obtain an execution environment
        final ParameterTool params = ParameterTool.fromArgs(args);
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.getConfig().setGlobalJobParameters(params);
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);

        // 2. Load/create the initial data
//        String bargunDataPath = "./data/bargunData.txt";
        DataStream<String> text;
        text = env.fromElements(MockScanData.SCAN_DATA);

        // 3. Specify transformations on this data,
        DataStream<ScanItem> scanItems = text
                .map(new MapFunction<String, ScanItem>() {
                    @Override
                    public ScanItem map(String line) throws Exception {
                        String[] fields = line.split(SEPARATOR);
                        return new ScanItem(fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]);
                    }
                });

        DataStream<ScanItem> counts = scanItems.flatMap(new Tokenizer())
                .keyBy("locationPostcode")
                .sum("amount");

        // 4. Specify where to put the results of your computations,
        counts.print();

        // 5. Trigger the program execution
        env.execute("Calculating inbounding parcel count for London Centre");
    }


    public static final class Tokenizer implements FlatMapFunction<ScanItem, ScanItem> {
        private static final long serialVersionUID = 1L;

        @Override
        public void flatMap(ScanItem scanItem, Collector<ScanItem> count) throws Exception {
            if (scanItem.getOperationId() == 11) {
                count.collect(scanItem);
            }
        }
    }


}

