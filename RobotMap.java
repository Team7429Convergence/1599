package frc.robot;

public class RobotMap {
    public static int DriveTrain_leftSlave = 0;
    public static int DriveTrain_leftMaster = 1;
    public static int DriveTrain_rightSlave = 2;
    public static int DriveTrain_rightMaster = 3;

    public static double DriveTrain_wheelSize = 8.0;
    public static int DriveTrain_encodersPerRev = 2048;
    public static double DriveTrain_gearRatio = 7.56;

    public static double kP = 5e-5; 
    public static double kI = 1e-6;
    public static double kD = 0; 
    public static double kIz = 0; 
    public static double kFF = 0.000156; 
    public static double kMaxOutput = 1; 
    public static double kMinOutput = -1;
}
