package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaExtremeHillsPlus;
import rtg.terrain.vanilla.TerrainVanillaExtremeHillsPlus;

public class RealisticBiomeVanillaExtremeHillsPlus extends RealisticBiomeVanilla
{	
	public static IBlockState topBlock = BiomeGenBase.extremeHillsPlus.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.extremeHillsPlus.fillerBlock;
	
	public RealisticBiomeVanillaExtremeHillsPlus()
	{
		super(
			BiomeGenBase.extremeHillsPlus,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.COLD),
			new TerrainVanillaExtremeHillsPlus(),
			new SurfaceVanillaExtremeHillsPlus(Blocks.gravel.getDefaultState(), Blocks.stone.getDefaultState(), false, null, 1f, 1.5f, 85f, 20f, 4f)
		);
	}	
}
