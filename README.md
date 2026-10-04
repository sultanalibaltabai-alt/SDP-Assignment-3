# Assignment 3 | Bridge Pattern

- Name: Sultanali
- Group: SE-2529
- Topic: A (Drawing)
- Repository: https://github.com/sultanalibaltabai-alt/SDP-Assignment-3.git
- Base commit: 7c77a168fa15e91a1eb64a4e0ca111cc9adc0fa1
- Submitted (final) commit: cf226e077fbb5fc165e07cfc9619c8542f3799aa

## Role map

| Role | Class | Path |
|---|---|---|
| Abstraction | Shape | src/Shape.java |
| A1 | Circle | src/Circle.java |
| A2 | Square | src/Square.java |
| Implementor | Renderer | src/Renderer.java |
| I1 | VectorRenderer | src/VectorRenderer.java |
| I2 | RasterRenderer | src/RasterRenderer.java |
| I3 | AsciiRenderer | src/AsciiRenderer.java |
| Client | Main | src/Main.java |

## Where things are

- Bridge field: `private Renderer renderer;` in src/Shape.java
- execute(): declared in Shape, implemented in Circle and Square
- setImplementation(...): `setImplementation(Renderer renderer)` in src/Shape.java
- T5 check: method `checkSwitch()` in src/Main.java

## Run

```
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main --demo
```

## Expected results

```
T1 PASS | Circle + VectorRenderer | result=VECTOR circle radius=2
T2 PASS | Circle + RasterRenderer | result=RASTER pixels of circle radius=2
T3 PASS | Square + VectorRenderer | result=VECTOR square side=3
T4 PASS | Square + RasterRenderer | result=RASTER pixels of square side=3
T5 PASS | sameObject=true | stateUnchanged=true
   before=VECTOR circle radius=2 | after=RASTER pixels of circle radius=2
T6 PASS | Circle + AsciiRenderer | result=ASCII art of circle radius=2
T7 PASS | Square + AsciiRenderer | result=ASCII art of square side=3
SUMMARY: 7/7 PASS
