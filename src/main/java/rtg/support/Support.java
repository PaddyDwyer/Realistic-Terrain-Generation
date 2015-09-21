package rtg.support;

import java.util.ArrayList;

import net.minecraftforge.fml.common.Loader;
import rtg.biomes.realistic.RealisticBiomeBase;
import rtg.config.ConfigRTG;

public class Support 
{
	public static ArrayList<RealisticBiomeBase> biomes_snow;
	public static ArrayList<RealisticBiomeBase> biomes_cold;
	public static ArrayList<RealisticBiomeBase> biomes_hot;
	public static ArrayList<RealisticBiomeBase> biomes_wet;
	public static ArrayList<RealisticBiomeBase> biomes_small;
	
    public enum BiomeCategory
    {
    	SNOW,
    	COLD,
    	HOT,
    	WET,
    	SMALL
    }
	
	public static void init()
	{
		biomes_snow = new ArrayList<RealisticBiomeBase>();
		biomes_cold = new ArrayList<RealisticBiomeBase>();
		biomes_hot = new ArrayList<RealisticBiomeBase>();
		biomes_wet = new ArrayList<RealisticBiomeBase>();
		biomes_small = new ArrayList<RealisticBiomeBase>();
		
		if (ConfigRTG.generateVanillaBiomes)
		{
			SupportVanilla.init();
		}
		
		if (Loader.isModLoaded("BiomesOPlenty"))
		{
			SupportBOP.init();
		}
		
		if (Loader.isModLoaded("ExtrabiomesXL"))
		{
			SupportEBXL.init();
		}
		
		if (Loader.isModLoaded("enhancedbiomes"))
		{
			SupportEB.init();
		}
		
		if (Loader.isModLoaded("Thaumcraft"))
		{
			SupportTC.init();
		}
	}
	
	public static void addBiome(RealisticBiomeSupport b, BiomeCategory cat)
	{
		try
		{
			switch(cat)
			{
				case SNOW: biomes_snow.add(b); break;
				case COLD: biomes_cold.add(b); break;
				case HOT: biomes_hot.add(b); break;
				case WET: biomes_wet.add(b); break;
				case SMALL: biomes_small.add(b); break;
			}
		}
		catch(Error e)
		{
			System.out.println("RTG Support: failed to add biome");
		}
	}
	
	public static void addBiome(RealisticBiomeSupport b, BiomeCategory[] cat)
	{
		for (int i = 0; i < cat.length; i++)
		{
			try
			{
				switch(cat[i])
				{
					case SNOW: biomes_snow.add(b); break;
					case COLD: biomes_cold.add(b); break;
					case HOT: biomes_hot.add(b); break;
					case WET: biomes_wet.add(b); break;
					case SMALL: biomes_small.add(b); break;
				}
			}
			catch(Error e)
			{
				System.out.println("RTG Support: failed to add biome");
			}
		}
	}
}
