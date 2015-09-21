package rtg.support;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.support.Support.BiomeCategory;
import rtg.surface.SurfaceGrassland;
import rtg.terrain.TerrainSmallSupport;

public class SupportTC 
{
	/*
	THAUMCRAFT BIOMES
	
	118: "Tainted Land"
	119: "Magical Forest"
	*/
	
	public static void init()
	{
		BiomeGenBase[] b = BiomeGenBase.getBiomeGenArray();
		
		for(int i = 0; i < 256; i++)
		{
			if(b[i] != null)
			{
				if(b[i].biomeName == "Tainted Land" || b[i].biomeName == "Magical Forest")
				{
					Support.addBiome(
						new RealisticBiomeSupport(
							b[i], VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.TEMPERATE),
							new TerrainSmallSupport(),
							new SurfaceGrassland(b[i].topBlock, b[i].fillerBlock, Blocks.stone, Blocks.cobblestone)
						),
						BiomeCategory.SMALL
					);
				}
			}
		}
	}
}
