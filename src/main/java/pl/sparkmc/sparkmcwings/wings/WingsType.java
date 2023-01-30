package pl.sparkmc.sparkmcwings.wings;

import java.util.Optional;

public enum WingsType {

    TEST(79, 79);


    public static Optional<WingsType> fromString(String name) {
        return Optional.of(WingsType.valueOf(name));
    }


    private final int leftCustomModelData;

    private final int rightCustomModelData;


    WingsType(int leftCustomModelData, int rightCustomModelData) {
        this.leftCustomModelData = leftCustomModelData;
        this.rightCustomModelData = rightCustomModelData;
    }


    public int getLeftCustomModelData() {
        return this.leftCustomModelData;
    }

    public int getRightCustomModelData() {
        return rightCustomModelData;
    }
}
