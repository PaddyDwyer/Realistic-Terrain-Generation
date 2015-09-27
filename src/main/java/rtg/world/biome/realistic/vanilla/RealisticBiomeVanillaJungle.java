package rtg.world.biome.realistic.vanilla;

import rtg.world.biome.BiomeBase;
import rtg.world.biome.BiomeBase.Climate;
import rtg.world.biome.realistic.RealisticBiomeBase;
import rtg.world.gen.surface.vanilla.SurfaceVanillaJungle;
import rtg.world.gen.terrain.vanilla.TerrainVanillaJungle;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

public class RealisticBiomeVanillaJungle extends RealisticBiomeVanillaBase
{	
	public static IBlockState topBlock = BiomeGenBase.jungle.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.jungle.fillerBlock;
	
	public RealisticBiomeVanillaJungle()
	{
		super(
			BiomeGenBase.jungle,
			BiomeBase.climatizedBiome(BiomeGenBase.river, BiomeBase.Climate.WET),
			new TerrainVanillaJungle(),
			new SurfaceVanillaJungle(topBlock, fillerBlock, Blocks.stone.getDefaultState(), Blocks.cobblestone.getDefaultState())
		);
	}	
}
