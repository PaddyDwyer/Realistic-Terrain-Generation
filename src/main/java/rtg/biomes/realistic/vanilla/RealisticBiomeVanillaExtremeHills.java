package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaExtremeHills;
import rtg.terrain.vanilla.TerrainVanillaExtremeHills;

public class RealisticBiomeVanillaExtremeHills extends RealisticBiomeVanilla
{	
	public static IBlockState topBlock = BiomeGenBase.extremeHills.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.extremeHills.fillerBlock;
	
	public RealisticBiomeVanillaExtremeHills()
	{
		super(
			BiomeGenBase.extremeHills,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.COLD),
			new TerrainVanillaExtremeHills(0f, 140f, 68f, 150f),
			new SurfaceVanillaExtremeHills(topBlock, fillerBlock, false, null, 1f, 1.5f, 85f, 20f, 4f)
		);
	}	
}
