package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LightsSubsystem extends SubsystemBase {

    AddressableLED       leds                 = new AddressableLED(0);
    AddressableLEDBuffer ledBuffer            = new AddressableLEDBuffer(30);


    private int          rainbowFirstPixelHue = 0;

    /** Creates a new DriveSubsystem. */
    public LightsSubsystem() {

        leds.setLength(ledBuffer.getLength());

        leds.setData(ledBuffer);
        leds.start();
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

    @Override
    public void periodic() {

        updateRainbow();
        leds.setData(ledBuffer);

        SmartDashboard.putNumber("Hue", rainbowFirstPixelHue);
    }

}
