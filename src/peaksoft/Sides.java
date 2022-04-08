package peaksoft;

import java.util.Random;

public interface Sides {


    default int dice() {
Random random = new Random();
int randCube = random.nextInt(1,7);

        switch (randCube) {
            case 1:
                System.out.println("""
                        +-------+ 
                        | #     |
                        |       |
                        |       |
                        +-------+ """);

            case 2:
                System.out.println("""
                        +-------+
                        | #     |                  
                        |       |
                        |    #  |                    
                        +-------+""");

            case 3:
                System.out.println("""
                        +-------+
                        | #     |
                        |   #   |
                        |    #  |
                        +-------+""");

            case 4:
                System.out.println("""
                        +-------+
                        | #   # |
                        |   #   |
                        |  #    |
                        +-------+""");

            case 5:
                System.out.println("""
                        +-------+
                        | #   # |
                        |   #   |
                        | #   # |
                        +-------+""");

            case 6:
                System.out.println("""
                        +-------+
                        | #   # |
                        | #   # |
                        | #   # |
                        +-------+""");

        }
        return randCube;

    }
}