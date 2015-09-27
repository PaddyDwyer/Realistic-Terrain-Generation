package rtg.world.biome.realistic.vanilla;

import rtg.world.biome.BiomeBase;
import rtg.world.biome.BiomeBase.Climate;
import rtg.world.biome.realistic.RealisticBiomeBase;
import rtg.world.gen.surface.vanilla.SurfaceVanillaColdTaigaHills;
import rtg.world.gen.terrain.vanilla.TerrainVanillaColdTaigaHills;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

public class RealisticBiomeVanillaColdTaigaHills extends RealisticBiomeVanillaBase
{	
	public static IBlockState topBlock = BiomeGenBase.coldTaigaHills.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.coldTaigaHills.fillerBlock;
	
	public RealisticBiomeVanillaColdTaigaHills()
	{
		super(
			BiomeGenBase.coldTaigaHills,
			BiomeBase.climatizedBiome(BiomeGenBase.river, BiomeBase.Climate.COLD),
			new TerrainVanillaColdTaigaHills(),
			new SurfaceVanillaColdTaigaHills(topBlock, fillerBlock)
		);
	}	
}
