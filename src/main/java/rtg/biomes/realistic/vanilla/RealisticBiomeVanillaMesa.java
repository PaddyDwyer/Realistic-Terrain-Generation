package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaMesa;
import rtg.terrain.vanilla.TerrainVanillaMesa;

public class RealisticBiomeVanillaMesa extends RealisticBiomeVanilla
{	
	public static IBlockState topBlock = BiomeGenBase.mesa.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.mesa.fillerBlock;
	
	public RealisticBiomeVanillaMesa()
	{
		super(
			BiomeGenBase.mesa,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.OASIS),
			new TerrainVanillaMesa(),
			//new SurfaceVanillaMesa(Blocks.sand.getDefaultState(), Blocks.sand.getDefaultState(), (byte)1)
			new SurfaceVanillaMesa(topBlock, fillerBlock)
		);
	}	
}
