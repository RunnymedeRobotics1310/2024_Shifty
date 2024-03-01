//package frc.robot.subsystems;
//
//import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj2.command.SubsystemBase;
//
//public class ArmSubsystem extends SubsystemBase {
//
//    private final LightsSubsystem lightsSubsystem;
//
//    private double                armSpeed            = 0;
//    private double                aimSpeed            = 0;
//    private double                intakeSpeed         = 0;
//    private double                shooterSpeed        = 0;
//
//    private double                encoderArmSpeed     = 0;
//    private double                encoderAimSpeed     = 0;
//    private double                encoderIntakeSpeed  = 0;
//    private double                encoderShooterSpeed = 0;
//    private double                encoderArmAngle     = 0;
//    private double                encoderAimAngle     = 0;
//
//    private DigitalInput          noteDetector        = new DigitalInput(1);
//
//    public ArmSubsystem(LightsSubsystem lightsSubsystem) {
//        this.lightsSubsystem = lightsSubsystem;
//    }
//
//    public void setArmSpeed(double speed) {
//        armSpeed = speed;
//    }
//
//    public void setAimSpeed(double speed) {
//        armSpeed = speed;
//    }
//
//    public void setIntakeSpeed(double intakeSpeed) {
//        this.intakeSpeed = intakeSpeed;
//    }
//
//    public void setShooterSpeed(double shooterSpeed) {
//        this.shooterSpeed = shooterSpeed;
//    }
//
//    public void stop() {
//        setArmSpeed(0);
//        setAimSpeed(0);
//        setIntakeSpeed(0);
//        setShooterSpeed(0);
//        encoderArmSpeed     = 0;
//        encoderAimSpeed     = 0;
//        encoderIntakeSpeed  = 0;
//        encoderShooterSpeed = 0;
//    }
//
//    public boolean isGamepieceDetected() {
//        return !noteDetector.get();
//    }
//
//    @Override
//    public void periodic() {
//
//        SmartDashboard.putNumber("Intake Speed", intakeSpeed);
//        SmartDashboard.putNumber("Encoder Intake Speed", encoderIntakeSpeed);
//
//        SmartDashboard.putNumber("Shooter Speed", shooterSpeed);
//        SmartDashboard.putNumber("Encoder Shooter Speed", encoderShooterSpeed);
//
//        SmartDashboard.putNumber("Arm Speed", armSpeed);
//        SmartDashboard.putNumber("Encoder Arm Speed", encoderArmSpeed);
//        SmartDashboard.putNumber("Arm Angle", encoderArmAngle);
//
//        SmartDashboard.putNumber("Aim Speed", aimSpeed);
//        SmartDashboard.putNumber("Encoder Aim Speed", encoderAimSpeed);
//        SmartDashboard.putNumber("Aim Angle", encoderAimAngle);
//
//        SmartDashboard.putBoolean("Is Gamepiece Detected", isGamepieceDetected());
//
//        if (intakeSpeed > encoderIntakeSpeed) {
//            encoderIntakeSpeed += .002;
//        }
//        else {
//            encoderIntakeSpeed -= .002;
//        }
//
//        boolean intakeAtTargetSpeed = Math.abs(shooterSpeed - encoderIntakeSpeed) < .05;
//
//        lightsSubsystem.setIntakeSpeed(encoderIntakeSpeed, intakeAtTargetSpeed);
//
//
//        if (shooterSpeed > encoderShooterSpeed) {
//            encoderShooterSpeed += .002;
//        }
//        else {
//            encoderShooterSpeed -= .002;
//        }
//
//        boolean shooterAtTargetSpeed = Math.abs(shooterSpeed - encoderShooterSpeed) < .05;
//
//        lightsSubsystem.setShooterSpeed(encoderShooterSpeed, shooterAtTargetSpeed);
//
//        lightsSubsystem.setArmAngle(encoderArmSpeed, shooterAtTargetSpeed);
//
//        lightsSubsystem.setAimAngle(encoderAimSpeed, shooterAtTargetSpeed);
//    }
//}
