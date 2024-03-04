package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbSubsystem extends SubsystemBase {


    private double  rightClimbSpeed   = 0;
    private double  leftClimbSpeed    = 0;

    private double  rightClimbEncoder = 0;
    private double  leftClimbEncoder  = 0;

    private boolean safetyEnabled     = false;
    private long    safetyStartTime   = 0;


    public void setClimbSpeeds(double leftClimbSpeed, double rightClimbSpeed) {

        this.leftClimbSpeed  = leftClimbSpeed;
        this.rightClimbSpeed = rightClimbSpeed;

        checkClimbSafety();
    }

    public double getRightClimbEncoder() {
        return rightClimbEncoder;
    }

    public double getLeftClimbEncoder() {
        return leftClimbEncoder;
    }


    public void stop() {
        setClimbSpeeds(0, 0);
    }

    @Override
    public void periodic() {


        // TODO REMOVE this code when the real robot is available

        // FAKE THE MOTOR ACTION
        leftClimbEncoder  += .01 * leftClimbSpeed;
        rightClimbEncoder += .01 * rightClimbSpeed;

        rightClimbEncoder  = Math.min(200, Math.max(0, rightClimbEncoder));
        leftClimbEncoder   = Math.min(200, Math.max(0, leftClimbEncoder));

        // END TODO Code removal

        /*
         * Safety-check all of the motors speeds, and
         * set the motor outputs.
         *
         * This is required because a command may set the motor speed
         * at the beginning and may not ever set it again. The periodic
         * loop checks the limits every loop.
         */
        setClimbSpeeds(leftClimbSpeed, rightClimbSpeed);

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
        SmartDashboard.putNumber("Left Climb Encoder", leftClimbEncoder);

        SmartDashboard.putNumber("Right Climb Speed", rightClimbSpeed);
        SmartDashboard.putNumber("Right Climb Encoder", rightClimbEncoder);

        SmartDashboard.putBoolean("Climb Safety", safetyEnabled);

    }

    private void checkClimbSafety() {

        // NOTE: Set safetyEnabled = true if a safety condition
        // is encountered

        // TODO:

        /*
         * RIGHT CLIMB RANGE
         *
         * if (rightClimbSpeed < 0 && rightClimbSpeedEncoder <= ClimbConstants.CLIMB_MIN) {
         * rightClimbSpeed = 0;
         * safetyEnabled = true;
         * safetyStartTime = System.currentTimeMillis();
         * System.out.println("right min");
         * }
         *
         * if (rightClimbSpeed > 0 && rightClimbSpeedEncoder <= ClimbConstants.CLIMB_MAX) {
         * rightClimbSpeed = 0;
         * safetyEnabled = true;
         * safetyStartTime = System.currentTimeMillis();
         * System.out.println("right max");
         * }
         *
         * /*
         * LEFT CLIMB RANGE
         *
         *
         * if (leftClimbSpeed < 0 && leftClimbSpeedEncoder <= ClimbConstants.CLIMB_MIN) {
         * leftClimbSpeed = 0;
         * safetyEnabled = true;
         * safetyStartTime = System.currentTimeMillis();
         * System.out.println("left min");
         * }
         *
         * if (leftClimbSpeed > 0 && leftClimbSpeedEncoder <= ClimbConstants.CLIMB_MAX) {
         * leftClimbSpeed = 0;
         * safetyEnabled = true;
         * safetyStartTime = System.currentTimeMillis();
         * System.out.println("left max");
         * }
         */

        return;
    }

}
