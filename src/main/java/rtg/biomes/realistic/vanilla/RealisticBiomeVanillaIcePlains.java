package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaIcePlains;
import rtg.terrain.vanilla.TerrainVanillaIcePlains;

public class RealisticBiomeVanillaIcePlains extends RealisticBiomeVanilla
{	
	public static IBlockState topBlock = BiomeGenBase.icePlains.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.icePlains.fillerBlock;
	
	public RealisticBiomeVanillaIcePlains()
	{
		super(
			BiomeGenBase.icePlains,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.ICE),
			new TerrainVanillaIcePlains(),
			new SurfaceVanillaIcePlains(topBlock, fillerBlock, topBlock, topBlock)
		);
	}	
}
