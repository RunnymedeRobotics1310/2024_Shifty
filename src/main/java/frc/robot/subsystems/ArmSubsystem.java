package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {

    private final LightsSubsystem lightsSubsystem;

    private double                linkPivotSpeed      = 0;
    private double                aimPivotSpeed       = 0;
    private double                intakeSpeed         = 0;
    private double                shooterSpeed        = 0;

    private double                intakeSpeedEncoder  = 0;
    private double                shooterSpeedEncoder = 0;
    private double                linkAngleEncoder    = 0;
    private double                aimAngleEncoder     = 0;

    private DigitalInput          noteDetector        = new DigitalInput(1);

    public ArmSubsystem(LightsSubsystem lightsSubsystem) {

        this.lightsSubsystem  = lightsSubsystem;

        // This is faking an angle encoder
        this.aimAngleEncoder  = ArmConstants.COMPACT_ARM_POSITION.aimAngle;
        this.linkAngleEncoder = ArmConstants.COMPACT_ARM_POSITION.linkAngle;
    }

    public double getAimAngle() {
        return aimAngleEncoder;
    }

    public double getLinkAngle() {
        return linkAngleEncoder;
    }

    public boolean isNoteDetected() {
        return !noteDetector.get();
    }

    public void setLinkPivotSpeed(double speed) {
        this.linkPivotSpeed = speed;
    }

    public void setAimPivotSpeed(double speed) {
        this.aimPivotSpeed = speed;
    }

    public void setIntakeSpeed(double intakeSpeed) {
        this.intakeSpeed = intakeSpeed;
    }

    public void setShooterSpeed(double shooterSpeed) {
        this.shooterSpeed = shooterSpeed;
    }

    public void stop() {
        setLinkPivotSpeed(0);
        setAimPivotSpeed(0);
        setIntakeSpeed(0);
        setShooterSpeed(0);
        intakeSpeedEncoder  = 0;
        shooterSpeedEncoder = 0;
    }

    @Override
    public void periodic() {

        // TODO REMOVE this code when the real robot is available

        // Fake some momentum in the motors by having them
        // slowly ramp towards the set speed. In reality,
        // this will happen much faster.
        if (intakeSpeed > intakeSpeedEncoder) {
            intakeSpeedEncoder += .002;
        }
        else if (intakeSpeed < intakeSpeedEncoder) {
            intakeSpeedEncoder -= .002;
        }

        if (shooterSpeed > shooterSpeedEncoder) {
            shooterSpeedEncoder += .002;
        }
        else if (shooterSpeed < shooterSpeedEncoder) {
            shooterSpeedEncoder -= .002;
        }

        // Move the aim and link angles based on the speed.
        aimAngleEncoder  = Math.min(130, Math.max(0, aimAngleEncoder + aimPivotSpeed));
        linkAngleEncoder = Math.min(130, Math.max(0, linkAngleEncoder + linkPivotSpeed));

        // END TODO Code removal


        /*
         * Update the SmartDashboard
         */

        SmartDashboard.putNumber("Intake Speed", intakeSpeed);
        SmartDashboard.putNumber("Encoder Intake Speed", intakeSpeedEncoder);

        SmartDashboard.putNumber("Shooter Speed", shooterSpeed);
        SmartDashboard.putNumber("Encoder Shooter Speed", shooterSpeedEncoder);

        SmartDashboard.putNumber("Link Speed", linkPivotSpeed);
        SmartDashboard.putNumber("Link Angle", getLinkAngle());

        SmartDashboard.putNumber("Aim Speed", aimPivotSpeed);
        SmartDashboard.putNumber("Aim Angle", getAimAngle());

        SmartDashboard.putBoolean("Note Held", isNoteDetected());

        // Update the lights
        updateLights();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(this.getClass().getSimpleName()).append(" : ")
            .append("Link ").append(getLinkAngle()).append("deg (").append(linkPivotSpeed).append(") ")
            .append("Aim ").append(getAimAngle()).append("deg (").append(aimPivotSpeed).append(") ")
            .append("Intake ").append(intakeSpeed).append(", ").append(intakeSpeedEncoder).append(' ')
            .append("Shooter ").append(shooterSpeed).append(", ").append(shooterSpeedEncoder).append(' ')
            .append("Game Piece ").append(isNoteDetected());

        return sb.toString();
    }

    private void updateLights() {

        boolean intakeAtTargetSpeed = Math.abs(shooterSpeed - intakeSpeedEncoder) < .05;

        lightsSubsystem.setIntakeSpeed(intakeSpeedEncoder, intakeAtTargetSpeed);

        boolean shooterAtTargetSpeed = Math.abs(shooterSpeed - shooterSpeedEncoder) < .05;

        lightsSubsystem.setShooterSpeed(shooterSpeedEncoder, shooterAtTargetSpeed);

        lightsSubsystem.setLinkAngle(getLinkAngle());

        lightsSubsystem.setAimAngle(getAimAngle());

        lightsSubsystem.setNoteHeld(isNoteDetected());
    }

}
