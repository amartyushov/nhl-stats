package io.mart.stats.service.player;

import java.util.Optional;

import io.mart.stats.converters.PlayerConverter;
import io.mart.stats.dto.PlayerDTO;
import io.mart.stats.entities.PlayerEntity;
import io.mart.stats.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	private final PlayerRepository playerRepository;
	private final PlayerConverter playerConverter;
	
	
	public PlayerServiceImpl(
			PlayerRepository playerRepository,
			PlayerConverter playerConverter) {
		this.playerRepository = playerRepository;
		this.playerConverter = playerConverter;
	}
	
	
	@Override
	public PlayerDTO create(PlayerDTO player) {
		Optional<PlayerEntity> retrievedPlayerEntity = playerRepository.findByPlayerId(player.getPlayerId());
		if (retrievedPlayerEntity.isPresent()) {
			return playerConverter.toDto(retrievedPlayerEntity.get());
		}
		
		PlayerEntity playerEntity = playerConverter.toEntity(player);
		PlayerEntity savedEntity = playerRepository.save(playerEntity);
		return playerConverter.toDto(savedEntity);
	}
}
