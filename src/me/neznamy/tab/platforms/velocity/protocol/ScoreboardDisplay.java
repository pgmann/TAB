package me.neznamy.tab.platforms.velocity.protocol;

import com.velocitypowered.api.network.ProtocolVersion;
import com.velocitypowered.proxy.connection.MinecraftSessionHandler;
import com.velocitypowered.proxy.protocol.MinecraftPacket;
import com.velocitypowered.proxy.protocol.ProtocolUtils;

import io.netty.buffer.ByteBuf;

public class ScoreboardDisplay implements MinecraftPacket{

	private byte position;
	private String name;

	public ScoreboardDisplay() {
	}

	public ScoreboardDisplay(final byte position, final String name) {
		this.position = position;
		this.name = name;
	}

	@Override
	public void decode(ByteBuf buf, ProtocolUtils.Direction direction, ProtocolVersion version) {
		position = buf.readByte();
		name = ProtocolUtils.readString(buf);
	}

	@Override
	public void encode(ByteBuf buf, ProtocolUtils.Direction direction, ProtocolVersion version) {
		buf.writeByte(position);
		ProtocolUtils.writeString(buf, name);
	}

	@Override
	public boolean handle(MinecraftSessionHandler handler) {
		return false;
	}
}