package rtg;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import rtg.biomes.base.BaseBiomes;
import rtg.config.RTGConfig;
import rtg.data.VillageMaterials;
import rtg.debug.DebugHandler;
import rtg.init.ModMapGen;
import rtg.proxy.CommonProxy;
import rtg.reference.ModInfo;
import rtg.support.Support;
import rtg.world.WorldTypeRealistic;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.MOD_VERSION, acceptableRemoteVersions = "*")
public class RTG {
	@Instance("RTG")
	public static RTG instance;

	public static String configPath;

	public static final WorldTypeRealistic worldtype = (new WorldTypeRealistic("RTG"));

	@SidedProxy(serverSide = ModInfo.PROXY_COMMON, clientSide = ModInfo.PROXY_CLIENT)
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		instance = this;

		configPath = event.getModConfigurationDirectory() + "/RTG/";
		RTGConfig.init(configPath);

		BaseBiomes.load();

		MinecraftForge.TERRAIN_GEN_BUS.register(new VillageMaterials());
		// MinecraftForge.TERRAIN_GEN_BUS.register(new TreeReplacement());

		ModMapGen.registerMapGen();
	}

	@EventHandler
	public void Init(FMLInitializationEvent event) {
		if (event.getSide() == Side.CLIENT) {
			MinecraftForge.EVENT_BUS.register(new DebugHandler());
		}
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		Support.init();
	}
}