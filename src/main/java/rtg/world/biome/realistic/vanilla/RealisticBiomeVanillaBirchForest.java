package rtg.world.biome.realistic.vanilla;

import rtg.world.biome.BiomeBase;
import rtg.world.biome.BiomeBase.Climate;
import rtg.world.biome.realistic.RealisticBiomeBase;
import rtg.world.gen.surface.vanilla.SurfaceVanillaBirchForest;
import rtg.world.gen.terrain.vanilla.TerrainVanillaBirchForest;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaBirchForest;
import rtg.terrain.vanilla.TerrainVanillaBirchForest;

public class RealisticBiomeVanillaBirchForest extends RealisticBiomeVanillaBase
{	
	public static IBlockState topBlock = BiomeGenBase.birchForest.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.birchForest.fillerBlock;
	
	public RealisticBiomeVanillaBirchForest()
	{
		super(
			BiomeGenBase.birchForest,
			BiomeBase.climatizedBiome(BiomeGenBase.river, BiomeBase.Climate.TEMPERATE),
			new TerrainVanillaBirchForest(),
			new SurfaceVanillaBirchForest(topBlock, fillerBlock, Blocks.stone.getDefaultState(), Blocks.cobblestone.getDefaultState())
		);
	}	
}
