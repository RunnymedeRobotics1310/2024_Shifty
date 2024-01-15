package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LightsSubsystem extends SubsystemBase {

    // Note: on Shifty, the lights are Y-ed, both of the strips run the same pattern.

    private final AddressableLED       ledStrip;
    private final AddressableLEDBuffer ledBuffer;
    private int                        rainbowFirstPixelHue = 0;
    private int                        firstPixelValue      = 0;

    /** Creates a new DriveSubsystem. */
    public LightsSubsystem() {

        ledStrip  = new AddressableLED(9);
        ledBuffer = new AddressableLEDBuffer(30);

        ledStrip.setLength(ledBuffer.getLength());
        ledStrip.setData(ledBuffer);

        ledStrip.start();
    }


    private void updateRainbow() {

        // For every pixel
        for (var i = 0; i < ledBuffer.getLength(); i++) {

            // Calculate the hue - hue is easier for rainbows because the color
            // shape is a circle so only one value needs to precess
            final var hue = (rainbowFirstPixelHue + (i * 180 / ledBuffer.getLength())) % 180;

            // Set the value
            ledBuffer.setHSV(i, hue, 255, 128);
        }

        // Increase by to make the rainbow "move"
        rainbowFirstPixelHue += 3;
        // Check bounds
        rainbowFirstPixelHue %= 180;
    }

    private void orange() {

        // For every pixel
        for (var i = 0; i < ledBuffer.getLength(); i++) {

            // Set the value
            ledBuffer.setHSV(i, 5, 255, 15);
        }

    }

    private void updateRed() {

        // For every pixel
        for (var i = 0; i < ledBuffer.getLength(); i++) {

            // Calculate the value - I want the orange to move
            // shape is a circle so only one value needs to precess
            final var value = (firstPixelValue + (i * 180 / ledBuffer.getLength())) % 180;

            // Set the value
            ledBuffer.setHSV(i, 0, 255, value);
        }

        // Increase by to make the rainbow "move"
        firstPixelValue += 2;

        // check bounds
        firstPixelValue %= 180;
    }

    private void updateOrange() {

        // For every pixel
        for (var i = 0; i < ledBuffer.getLength(); i++) {

            // Calculate the value - I want the orange to move
            // shape is a circle so only one value needs to precess
            final var value = (firstPixelValue + (i * 180 / ledBuffer.getLength())) % 180;

            // Set the value
            ledBuffer.setHSV(i, 2, 255, value);
        }

        // Increase by to make the rainbow "move"
        firstPixelValue += 2;

        // check bounds
        firstPixelValue %= 180;
    }

    private void updateYellow() {

        // For every pixel
        for (var i = 0; i < ledBuffer.getLength(); i++) {

            // Calculate the value - I want the orange to move
            // shape is a circle so only one value needs to precess
            final var value = (firstPixelValue + (i * 180 / ledBuffer.getLength())) % 180;

            // Set the value
            ledBuffer.setHSV(i, 10, 255, value);
        }

        // Increase by to make the rainbow "move"
        firstPixelValue += 2;

        // check bounds
        firstPixelValue %= 180;
    }

    private void updateGreen() {

        // For every pixel
        for (var i = 0; i < ledBuffer.getLength(); i++) {

            // Calculate the value - I want the orange to move
            // shape is a circle so only one value needs to precess
            final var value = (firstPixelValue + (i * 180 / ledBuffer.getLength())) % 180;

            // Set the value
            ledBuffer.setHSV(i, 50, 255, value);
        }

        // Increase by to make the rainbow "move"
        firstPixelValue += 2;

        // check bounds
        firstPixelValue %= 180;
    }

    private void updateBlue() {

        // For every pixel
        for (var i = 0; i < ledBuffer.getLength(); i++) {

            // Calculate the value - I want the orange to move
            // shape is a circle so only one value needs to precess
            final var value = (firstPixelValue + (i * 180 / ledBuffer.getLength())) % 180;

            // Set the value
            ledBuffer.setHSV(i, 300, 255, value);
        }

        // Increase by to make the rainbow "move"
        firstPixelValue += 2;

        // check bounds
        firstPixelValue %= 180;
    }

    private void updatePurple() {

        // For every pixel
        for (var i = 0; i < ledBuffer.getLength(); i++) {

            // Calculate the value - I want the orange to move
            // shape is a circle so only one value needs to precess
            final var value = (firstPixelValue + (i * 180 / ledBuffer.getLength())) % 180;

            // Set the value
            ledBuffer.setHSV(i, 315, 255, value);
        }

        // Increase by to make the rainbow "move"
        firstPixelValue += 2;

        // check bounds
        firstPixelValue %= 180;
    }

    private void updatePink() {

        // For every pixel
        for (var i = 0; i < ledBuffer.getLength(); i++) {

            // Calculate the value - I want the orange to move
            // shape is a circle so only one value needs to precess
            final var value = (firstPixelValue + (i * 180 / ledBuffer.getLength())) % 180;

            // Set the value
            ledBuffer.setHSV(i, 359, 255, value);
        }

        // Increase by to make the rainbow "move"
        firstPixelValue += 2;

        // check bounds
        firstPixelValue %= 180;
    }

    private void endGame() {

        // For every pixel
        for (var i = 0; i < ledBuffer.getLength(); i++) {

            // Calculate the value - I want the orange to move
            // shape is a circle so only one value needs to precess
            final var value = (firstPixelValue + (i * 180 / ledBuffer.getLength())) % 180;

            // Set the value
            ledBuffer.setHSV(i, 0, 255, value);
        }

        // Increase by to make the rainbow "move"
        firstPixelValue -= 10;

        // check bounds
        firstPixelValue %= 180;
    }

    @Override
    public void periodic() {

        updateOrange();
        ledStrip.setData(ledBuffer);

        // SmartDashboard.putNumber("Hue", rainbowFirstPixelHue);
    }

}
