// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {

    // Global constants
    public static final double DEFAULT_COMMAND_TIMEOUT_SECONDS = 5;

    public static final class AutoConstants {

        public static enum AutoPattern {
            DO_NOTHING, DRIVE_FORWARD, OTHER_AUTO, THREE_NOTE
        };
    }

    public static final class DriveConstants {

        public static enum DriveMode {
            TANK, SINGLE_STICK_ARCADE, DUAL_STICK_ARCADE;
        }

        public static enum Shifter {
            HIGH, LOW
        };

        public static final int     LEFT_MOTOR_PORT               = 10;
        public static final int     RIGHT_MOTOR_PORT              = 20;

        public static final boolean LEFT_MOTOR_REVERSED           = true;
        public static final boolean RIGHT_MOTOR_REVERSED          = false;

        public static final boolean LEFT_ENCODER_REVERSED         = false;
        public static final boolean RIGHT_ENCODER_REVERSED        = true;

        public static final int     ENCODER_COUNTS_PER_REVOLUTION = 1024;
        public static final double  ROBOT_WHEEL_DIAMETER_CMS      = 6 * 2.54;

        public static final double  CMS_PER_ENCODER_COUNT         =
            // Assumes the encoders are directly mounted on the wheel shafts
            (ROBOT_WHEEL_DIAMETER_CMS * Math.PI) / ENCODER_COUNTS_PER_REVOLUTION;

        public static final int     SHIFTER_PNEUMATIC_PORT        = 0;
    }

    public static final class OperatorConstants {

        public static final int    DRIVER_CONTROLLER_PORT         = 0;
        public static final double GAME_CONTROLLER_STICK_DEADBAND = 0.2;
    }

    public static final class LightsConstants {

        public static final int LIGHT_STRING_PWM_PORT = 9;
        public static final int LIGHT_STRING_LENGTH   = 60;
    }

    public static class ArmPosition {

        public final double linkAngle;
        public final double aimAngle;

        public ArmPosition(double armAngle, double aimAngle) {
            this.linkAngle = armAngle;
            this.aimAngle  = aimAngle;
        }
    }

    public static final class ArmConstants {

        public static final ArmPosition COMPACT_ARM_POSITION       = new ArmPosition(100.0, 75.0);
        public static final ArmPosition OVER_BUMPER_POSITION       = new ArmPosition(60.0, 125.0);
        public static final ArmPosition INTAKE_ARM_POSITION        = new ArmPosition(20.0, 160.0);

        public static final ArmPosition SHOOT_SPEAKER_ARM_POSITION = new ArmPosition(115.0, 90.0);
        public static final ArmPosition SHOOT_AMP_ARM_POSITION     = new ArmPosition(125.0, 160.0);
        public static final ArmPosition TRAP_ARM_POSITION          = new ArmPosition(145.0, 165.0);

        public static final double      FAST_AIM_SPEED             = .3;
        public static final double      SLOW_AIM_SPEED             = .1;
        public static final double      FAST_LINK_SPEED            = .3;
        public static final double      SLOW_LINK_SPEED            = .1;

        public static final double      SLOW_ARM_ZONE_DEG          = 20.0;
        public static final double      AT_TARGET_DEG              = 1;

        public static final double      INTAKE_SPEED               = 1;
        public static final double      SHOOTER_SPEED              = 1;
    }
}
