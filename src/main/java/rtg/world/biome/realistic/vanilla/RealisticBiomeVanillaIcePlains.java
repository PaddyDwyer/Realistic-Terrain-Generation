package rtg.world.biome.realistic.vanilla;

import rtg.world.biome.BiomeBase;
import rtg.world.biome.BiomeBase.Climate;
import rtg.world.biome.realistic.RealisticBiomeBase;
import rtg.world.gen.surface.vanilla.SurfaceVanillaIcePlains;
import rtg.world.gen.terrain.vanilla.TerrainVanillaIcePlains;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaIcePlains;
import rtg.terrain.vanilla.TerrainVanillaIcePlains;

public class RealisticBiomeVanillaIcePlains extends RealisticBiomeVanillaBase
{	
	public static IBlockState topBlock = BiomeGenBase.icePlains.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.icePlains.fillerBlock;
	
	public RealisticBiomeVanillaIcePlains()
	{
		super(
			BiomeGenBase.icePlains,
			BiomeBase.climatizedBiome(BiomeGenBase.river, BiomeBase.Climate.ICE),
			new TerrainVanillaIcePlains(),
			new SurfaceVanillaIcePlains(topBlock, fillerBlock, topBlock, topBlock)
		);
	}	
}
