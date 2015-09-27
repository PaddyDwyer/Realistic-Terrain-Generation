package rtg.world.gen.terrain.vanilla;

import rtg.util.CellNoise;
import rtg.util.PerlinNoise;
import rtg.world.gen.terrain.TerrainBase;

public class TerrainVanillaIcePlains extends TerrainBase
{
	public TerrainVanillaIcePlains()
	{
	}
	
	@Override
	public float generateNoise(PerlinNoise perlin, CellNoise cell, int x, int y, float ocean, float border, float river)
	{
		float h = perlin.noise2(x / 300f, y / 300f) * 40f * river;
		h = h > 3f ? 3f : h; 
		h += perlin.noise2(x / 50f, y / 50f) * (12f - h) * 0.4f;
		h += perlin.noise2(x / 15f, y / 15f) * (12f - h) * 0.15f;
		
		return 62f + h;
	}
}
