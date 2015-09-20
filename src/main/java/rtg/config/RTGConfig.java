package rtg.config;

import java.io.File;

public class RTGConfig
{
	public static File rtgConfigFile;
	public static File bopConfigFile;
	public static File VanillaConfigFile;

	public static void init(String configpath)
	{
		rtgConfigFile = new File(configpath + "ConfigRTG.cfg");
		bopConfigFile = new File(configpath + "ConfigBOP.cfg");
		VanillaConfigFile  = new File(configpath + "ConfigVanilla.cfg");

		ConfigRTG.init(rtgConfigFile);
		ConfigBOP.init(bopConfigFile);
		ConfigVanilla.init(VanillaConfigFile);

	}
}
