package rtg.world.biome.realistic.vanilla;

import rtg.world.biome.BiomeBase;
import rtg.world.biome.BiomeBase.Climate;
import rtg.world.biome.realistic.RealisticBiomeBase;
import rtg.world.gen.surface.vanilla.SurfaceVanillaTaigaHills;
import rtg.world.gen.terrain.vanilla.TerrainVanillaTaigaHills;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

public class RealisticBiomeVanillaTaigaHills extends RealisticBiomeVanillaBase
{	
	public static IBlockState topBlock = BiomeGenBase.taigaHills.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.taigaHills.fillerBlock;
	
	public RealisticBiomeVanillaTaigaHills()
	{
		super(
			BiomeGenBase.taigaHills,
			BiomeBase.climatizedBiome(BiomeGenBase.river, BiomeBase.Climate.COLD),
			new TerrainVanillaTaigaHills(),
			new SurfaceVanillaTaigaHills(topBlock, fillerBlock, true, Blocks.sand.getDefaultState(), 0.2f)
		);
	}	
}
