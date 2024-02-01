package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    private final LightsSubsystem lightsSubsystem;

    private double                motorSpeed       = 0;
    private double                actualMotorSpeed = 0;

    public IntakeSubsystem(LightsSubsystem lightsSubsystem) {
        this.lightsSubsystem = lightsSubsystem;
    }

    public void setIntakeSpeed(double speed) {
        motorSpeed = speed;
    }

    public void stop() {
        setIntakeSpeed(0);
        actualMotorSpeed = 0;
    }

    @Override
    public void periodic() {

        SmartDashboard.putNumber("Intake Speed", motorSpeed);
        SmartDashboard.putNumber("Actual Intake Speed", actualMotorSpeed);

        if (motorSpeed > actualMotorSpeed) {
            actualMotorSpeed += .002;
        }
        else {
            actualMotorSpeed -= .002;
        }

        boolean atTargetSpeed = Math.abs(motorSpeed - actualMotorSpeed) < .05;

        lightsSubsystem.setIntakeSpeed(actualMotorSpeed, atTargetSpeed);
    }
}
