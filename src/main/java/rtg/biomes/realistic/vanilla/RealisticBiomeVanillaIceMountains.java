package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaIceMountains;
import rtg.terrain.vanilla.TerrainVanillaIceMountains;

public class RealisticBiomeVanillaIceMountains extends RealisticBiomeVanilla
{	
	public static IBlockState topBlock = BiomeGenBase.iceMountains.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.iceMountains.fillerBlock;
	
	public RealisticBiomeVanillaIceMountains()
	{
		super(
			BiomeGenBase.iceMountains,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.ICE),
			new TerrainVanillaIceMountains(),
			new SurfaceVanillaIceMountains(topBlock, fillerBlock, Blocks.packed_ice.getDefaultState(), Blocks.ice.getDefaultState())
		);
	}	
}
