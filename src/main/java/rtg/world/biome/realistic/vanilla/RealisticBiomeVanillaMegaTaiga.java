package rtg.world.biome.realistic.vanilla;

import rtg.world.biome.BiomeBase;
import rtg.world.biome.BiomeBase.Climate;
import rtg.world.biome.realistic.RealisticBiomeBase;
import rtg.world.gen.surface.vanilla.SurfaceVanillaMegaTaiga;
import rtg.world.gen.terrain.vanilla.TerrainVanillaMegaTaiga;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

public class RealisticBiomeVanillaMegaTaiga extends RealisticBiomeVanillaBase
{	
	public static IBlockState topBlock = BiomeGenBase.megaTaiga.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.megaTaiga.fillerBlock;
	
	public RealisticBiomeVanillaMegaTaiga()
	{
		super(
			BiomeGenBase.megaTaiga,
			BiomeBase.climatizedBiome(BiomeGenBase.river, BiomeBase.Climate.COLD),
			new TerrainVanillaMegaTaiga(230f, 120f, 90f),
			new SurfaceVanillaMegaTaiga(topBlock, fillerBlock, true, Blocks.sand.getDefaultState(), 0.2f)
		);
	}	
}
