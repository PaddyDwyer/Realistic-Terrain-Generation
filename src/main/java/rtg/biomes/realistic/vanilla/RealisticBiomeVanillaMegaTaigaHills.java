package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaMegaTaigaHills;
import rtg.terrain.vanilla.TerrainVanillaMegaTaigaHills;

public class RealisticBiomeVanillaMegaTaigaHills extends RealisticBiomeVanilla
{	
	public static IBlockState topBlock = BiomeGenBase.megaTaigaHills.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.megaTaigaHills.fillerBlock;
	
	public RealisticBiomeVanillaMegaTaigaHills()
	{
		super(
			BiomeGenBase.megaTaigaHills,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.COLD),
			new TerrainVanillaMegaTaigaHills(230f, 120f, 90f),
			new SurfaceVanillaMegaTaigaHills(topBlock, fillerBlock, true, Blocks.sand.getDefaultState(), 0.2f)
		);
	}	
}
