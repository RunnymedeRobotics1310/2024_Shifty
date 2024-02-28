package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimbConstants;

public class ClimbSubsystem extends SubsystemBase {


    private double  rightClimbSpeed        = 0;
    private double  leftClimbSpeed         = 0;

    private double  rightClimbSpeedEncoder = 0;
    private double  leftClimbSpeedEncoder  = 0;

    private boolean safetyEnabled          = false;
    private long    safetyStartTime        = 0;

    public double getRightClimbSpeed() {
        return rightClimbSpeedEncoder;
    }

    public double getLeftClimbSpeed() {
        return leftClimbSpeedEncoder;
    }


    public void setRightClimbSpeed(double speed) {
        this.rightClimbSpeed = speed;

        checkClimbSafety();

    }

    public void setLeftClimbSpeed(double speed) {
        this.leftClimbSpeed = speed;

        checkClimbSafety();


    }


    public void stop() {
        setRightClimbSpeed(0);
        setLeftClimbSpeed(0);
    }

    @Override
    public void periodic() {


        // TODO REMOVE this code when the real robot is available

        // FAKE THE MOTOR ACTION
        if (leftClimbSpeed > leftClimbSpeedEncoder) {
            leftClimbSpeedEncoder += .002;
        }
        else if (leftClimbSpeed < leftClimbSpeedEncoder) {
            leftClimbSpeedEncoder -= .002;
        }

        if (rightClimbSpeed > rightClimbSpeedEncoder) {
            rightClimbSpeedEncoder += .002;
        }
        else if (rightClimbSpeed < rightClimbSpeedEncoder) {
            rightClimbSpeedEncoder -= .002;
        }

        // Move the aim and link angles based on the speed.
        rightClimbSpeedEncoder = Math.min(200, Math.max(0, rightClimbSpeedEncoder + rightClimbSpeedEncoder));
        leftClimbSpeedEncoder  = Math.min(200, Math.max(0, leftClimbSpeedEncoder + leftClimbSpeedEncoder));

        // END TODO Code removal

        /*
         * Safety-check all of the motors speeds, and
         * set the motor outputs.
         *
         * This is required because a command may set the motor speed
         * at the beginning and may not ever set it again. The periodic
         * loop checks the limits every loop.
         */
        setLeftClimbSpeed(leftClimbSpeed);
        setRightClimbSpeed(rightClimbSpeed);

        // Latch the climb safety for 2 seconds when a safety condition
        // is activated.
        if (safetyEnabled) {
            if ((System.currentTimeMillis() - safetyStartTime) > 2000) {
                safetyEnabled = false;
            }
        }

        /*
         * Update the SmartDashboard
         */

        SmartDashboard.putNumber("Left Climb Speed", leftClimbSpeed);
        SmartDashboard.putNumber("Encoder Left Climb Speed", leftClimbSpeedEncoder);

        SmartDashboard.putNumber("Right Climb Speed", rightClimbSpeed);
        SmartDashboard.putNumber("Encoder Right Climb Speed", rightClimbSpeedEncoder);

        SmartDashboard.putBoolean("Climb Safety", safetyEnabled);

    }

    private void checkClimbSafety() {

        // NOTE: Set safetyEnabled = true if a safety condition
        // is encountered

        // TODO:

        /*
         * RIGHT CLIMB RANGE
         */
        if (rightClimbSpeed < 0 && rightClimbSpeedEncoder <= ClimbConstants.CLIMB_MIN) {
            rightClimbSpeed = 0;
            safetyEnabled   = true;
            safetyStartTime = System.currentTimeMillis();
        }

        if (rightClimbSpeed > 0 && rightClimbSpeedEncoder <= ClimbConstants.CLIMB_MAX) {
            rightClimbSpeed = 0;
            safetyEnabled   = true;
            safetyStartTime = System.currentTimeMillis();
        }

        /*
         * LEFT CLIMB RANGE
         */

        if (leftClimbSpeed < 0 && leftClimbSpeedEncoder <= ClimbConstants.CLIMB_MIN) {
            leftClimbSpeed  = 0;
            safetyEnabled   = true;
            safetyStartTime = System.currentTimeMillis();
        }

        if (leftClimbSpeed > 0 && leftClimbSpeedEncoder <= ClimbConstants.CLIMB_MAX) {
            leftClimbSpeed  = 0;
            safetyEnabled   = true;
            safetyStartTime = System.currentTimeMillis();
        }

        return;
    }
}
