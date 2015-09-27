package rtg.world.biome.realistic.vanilla;

import rtg.world.biome.BiomeBase;
import rtg.world.biome.BiomeBase.Climate;
import rtg.world.biome.realistic.RealisticBiomeBase;
import rtg.world.gen.surface.vanilla.SurfaceVanillaSwampland;
import rtg.world.gen.terrain.vanilla.TerrainVanillaSwampland;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

public class RealisticBiomeVanillaSwampland extends RealisticBiomeVanillaBase
{	
	public static IBlockState topBlock = BiomeGenBase.swampland.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.swampland.fillerBlock;
	
	public RealisticBiomeVanillaSwampland()
	{
		super(
			BiomeGenBase.swampland,
			BiomeBase.climatizedBiome(BiomeGenBase.river, BiomeBase.Climate.WET),
			new TerrainVanillaSwampland(),
			new SurfaceVanillaSwampland(topBlock, fillerBlock, Blocks.stone.getDefaultState(), Blocks.cobblestone.getDefaultState())
		);
	}	
}
