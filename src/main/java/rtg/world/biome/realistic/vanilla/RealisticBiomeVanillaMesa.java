package rtg.world.biome.realistic.vanilla;

import rtg.world.biome.BiomeBase;
import rtg.world.biome.BiomeBase.Climate;
import rtg.world.biome.realistic.RealisticBiomeBase;
import rtg.world.gen.surface.vanilla.SurfaceVanillaMesa;
import rtg.world.gen.terrain.vanilla.TerrainVanillaMesa;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

public class RealisticBiomeVanillaMesa extends RealisticBiomeVanillaBase
{	
	public static IBlockState topBlock = BiomeGenBase.mesa.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.mesa.fillerBlock;
	
	public RealisticBiomeVanillaMesa()
	{
		super(
			BiomeGenBase.mesa,
			BiomeBase.climatizedBiome(BiomeGenBase.river, BiomeBase.Climate.OASIS),
			new TerrainVanillaMesa(),
			//new SurfaceVanillaMesa(Blocks.sand.getDefaultState(), Blocks.sand.getDefaultState(), (byte)1)
			new SurfaceVanillaMesa(topBlock, fillerBlock)
		);
	}	
}
