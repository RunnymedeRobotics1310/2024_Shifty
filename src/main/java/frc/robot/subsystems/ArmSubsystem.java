package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {

    private final LightsSubsystem lightsSubsystem;

    private double                armSpeed            = 0;
    private double                aimSpeed            = 0;
    private double                intakeSpeed         = 0;
    private double                shooterSpeed        = 0;

    private double                intakeSpeedEncoder  = 0;
    private double                shooterSpeedEncoder = 0;
    private double                armAngleEncoder     = 0;
    private double                aimAngleEncoder     = 0;

    private DigitalInput          noteDetector        = new DigitalInput(1);

    public ArmSubsystem(LightsSubsystem lightsSubsystem) {

        this.lightsSubsystem = lightsSubsystem;

        // This is faking an angle encoder
        this.aimAngleEncoder = ArmConstants.COMPACT_ARM_POSITION.aimAngle;
        this.armAngleEncoder = ArmConstants.COMPACT_ARM_POSITION.armAngle;
    }

    public double getAimAngle() {
        return aimAngleEncoder;
    }

    public double getArmAngle() {
        return aimAngleEncoder;
    }

    public void setArmSpeed(double speed) {
        this.armSpeed = speed;
    }

    public void setAimSpeed(double speed) {
        this.aimSpeed = speed;
    }

    public void setIntakeSpeed(double intakeSpeed) {
        this.intakeSpeed = intakeSpeed;
    }

    public void setShooterSpeed(double shooterSpeed) {
        this.shooterSpeed = shooterSpeed;
    }

    public void stop() {
        setArmSpeed(0);
        setAimSpeed(0);
        setIntakeSpeed(0);
        setShooterSpeed(0);
        intakeSpeedEncoder  = 0;
        shooterSpeedEncoder = 0;
    }

    public boolean isGamepieceDetected() {
        return !noteDetector.get();
    }

    @Override
    public void periodic() {

        SmartDashboard.putNumber("Intake Speed", intakeSpeed);
        SmartDashboard.putNumber("Encoder Intake Speed", intakeSpeedEncoder);

        SmartDashboard.putNumber("Shooter Speed", shooterSpeed);
        SmartDashboard.putNumber("Encoder Shooter Speed", shooterSpeedEncoder);

        SmartDashboard.putNumber("Arm Speed", armSpeed);
        SmartDashboard.putNumber("Arm Angle", getArmAngle());

        SmartDashboard.putNumber("Aim Speed", aimSpeed);
        SmartDashboard.putNumber("Aim Angle", getAimAngle());

        SmartDashboard.putBoolean("Is Gamepiece Detected", isGamepieceDetected());

        // Move the aim and arm angles based on the speed.
        aimAngleEncoder += aimSpeed;
        armAngleEncoder += armSpeed;

        if (intakeSpeed > intakeSpeedEncoder) {
            intakeSpeedEncoder += .002;
        }
        else {
            intakeSpeedEncoder -= .002;
        }

        if (shooterSpeed > shooterSpeedEncoder) {
            shooterSpeedEncoder += .002;
        }
        else {
            shooterSpeedEncoder -= .002;
        }


        updateLights();
    }

    private void updateLights() {

        boolean intakeAtTargetSpeed = Math.abs(shooterSpeed - intakeSpeedEncoder) < .05;

        lightsSubsystem.setIntakeSpeed(intakeSpeedEncoder, intakeAtTargetSpeed);

        boolean shooterAtTargetSpeed = Math.abs(shooterSpeed - shooterSpeedEncoder) < .05;

        lightsSubsystem.setShooterSpeed(shooterSpeedEncoder, shooterAtTargetSpeed);

        lightsSubsystem.setArmAngle(getArmAngle());

        lightsSubsystem.setAimAngle(getAimAngle());
    }

}
