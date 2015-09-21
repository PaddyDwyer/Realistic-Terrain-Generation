package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaExtremeHillsPlus;
import rtg.terrain.vanilla.TerrainVanillaExtremeHillsPlus;

public class RealisticBiomeVanillaExtremeHillsPlus extends RealisticBiomeVanilla
{	
	public static Block topBlock = BiomeGenBase.extremeHillsPlus.topBlock;
	public static Block fillerBlock = BiomeGenBase.extremeHillsPlus.fillerBlock;
	
	public RealisticBiomeVanillaExtremeHillsPlus()
	{
		super(
			BiomeGenBase.extremeHillsPlus,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.COLD),
			new TerrainVanillaExtremeHillsPlus(),
			new SurfaceVanillaExtremeHillsPlus(Blocks.gravel, Blocks.stone, false, null, 1f, 1.5f, 85f, 20f, 4f)
		);
	}	
}
