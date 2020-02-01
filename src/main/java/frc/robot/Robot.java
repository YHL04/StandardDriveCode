
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
  private DriveTrain driveTrain;


  @Override
  public void robotInit() {
    driveTrain = new DriveTrain();
  }

  @Override
  public void teleopPeriodic() {
    driveTrain.run();
  }

  @Override
  public void testPeriodic() {
  }
}
