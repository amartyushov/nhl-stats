package io.mart.stats.service.player;

import io.mart.stats.dto.PlayerDTO;
import io.mart.stats.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	private final PlayerRepository playerRepository;
	
	
	public PlayerServiceImpl(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}
	
	
	@Override
	public PlayerDTO create(PlayerDTO player) {
		
		return null;
	}
}
