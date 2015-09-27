package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaTaigaHills;
import rtg.terrain.vanilla.TerrainVanillaTaigaHills;

public class RealisticBiomeVanillaTaigaHills extends RealisticBiomeVanilla
{	
	public static IBlockState topBlock = BiomeGenBase.taigaHills.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.taigaHills.fillerBlock;
	
	public RealisticBiomeVanillaTaigaHills()
	{
		super(
			BiomeGenBase.taigaHills,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.COLD),
			new TerrainVanillaTaigaHills(),
			new SurfaceVanillaTaigaHills(topBlock, fillerBlock, true, Blocks.sand.getDefaultState(), 0.2f)
		);
	}	
}
