# Bargun Data Simulation

| Operation Code | Parcel ID | Location ID | Operator ID | Datetime | Destination Postcode |

If any field is not available during a specific scan, it will show as N/A.

### Example Operation Code

Very happy path operation codes

- 10 parcel collected
- 11 parcel received at service centre
- 12 parcel dispatched from service centre
- 13 parcel received at sort centre
- 14 parcel dispatched from sort centre
- 15 parcel out for delivery
- 16 parcel delivered

### Example Location ID
Use this to refer to where the scan occurs, could be a sort centre or a service centre.
Here I will use postcode to represent sort/service centres.

**Sort and Transport Centres**

- `WS10` Wednesbury
- `AL10` Hatfield
- `OL2` Shaw 

**Service Centres**

- Aberdeen `AB12 3LY`
- Alfreton `DE55 7RA`
- Carlisle `CA3 0EH`
- Carrickfergus `BT38 8PH`
- Gateshead `NE11 0BH`
- Glasgow `ML4 3NR`
- Inverness `IV3 8EA`
- IOM ` IM4 4LG`
- Keighley `BD21 4DZ`
- Kilmarnock `KA1 2NN`
- Leeds `LS27 7JZ`
- Lichfield `WS13 8SY`
- Lincoln `LN6 3RS`
- Livingston `EH54 5DL`
- Llandudno `LL31 9PW`
- Middleton `M24 2SJ`
- Oban `PA34 4HG`
- Omagh `BT79 0EU`
- Perth `PH1 3JE`
- Preston `PR5 8AH`
- Sandwell `B69 2RB`
- Selby `Y08 8GA`
- Sheffield `S9 1XA`
- Stockton `TS18 2SG`
- Stoke `ST6 4PB`
- Warrington `WA3 6NH`
- Wrexham `LL11 4YL`
- Aberystwyth `SY23 3FF`
- Aylesham `CT3 3BD`
- Basildon `SS13 1TL`
- Borehamwood `WD6 1RU`
- Bristol `BS32 4JQ`
- Cambridge `CB23 8SS`
- Chessington `KT9 1TJ`
- Dartford `DA2 6QP`
- Farnborough `GU14 0NR`
- Gatwick `RH11 7ST`
- Gloucester `GL2 4NF`
- Hayes `UB3 4PU`
- Horndean `PO8 9JU`
- Ipswich `IP2 0UF`
- Isle of Wight `PO30 3BT`
- Leamington Spa `CV34 6QP`
- Llanelli `SA14 8QW`
- London Central `SE1 5SR`
- Maidstone `ME20 6SW`
- Mitcham `CR4 4HX`
- Nantgarw `CF15 7QZ`
- Newton Abbot `TQ12 6TN`
- North Devon `EX363LH`
- Northampton `NN4 7PN`
- Norwich `NR7 0WH`
- Peterborough `PE2 6UP`
- Reading `RG2 0TG`
- Southampton `PO15 5ST`
- Truro `TR1 3LP`
- Waltham Cross  `EN3 7XQ`
- Yeovil `BA20 2PJ`
- Atlantic Pavilion `L3 4AE`

### Operator ID
It could be the worker who scan the parcel by HHT or an overhead scanner.

### Datetime

Format: `YYYYDDMM HHMMSS`

Example: `20161231 162020`

### Example Destination Postcode
I'm not sure if this is included in every scan, just put it here in case it is.

example: `W1F 0UR`

### Happy path example
```
|10|JD0002293888000125|N/A|C01|20161225 160000|L3 4AE|
|11|JD0002293888000125|SE1 5SR|W01|20161225 180000|L3 4AE|
|12|JD0002293888000125|SE1 5SR|W01|20161225 200000|L3 4AE|
|13|JD0002293888000125|WS10|W02|20161225 230000|L3 4AE|
|14|JD0002293888000125|WS10|W03|20161226 040000|L3 4AE|
|11|JD0002293888000125|WA3 6NH|W04|20161226 080000|L3 4AE|
|15|JD0002293888000125|WA3 6NH|W05|20161226 100000|L3 4AE|
|16|JD0002293888000125|N/A|C03|20161226 180000|L3 4AE|
```

Imagine a parcel delivered from London to Liverpool, I fake the path to from `London Central` via `Wednesbury` to `Warrington`.
And there will be 8 scans during the whole journey. 

