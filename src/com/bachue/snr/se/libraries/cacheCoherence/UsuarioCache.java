package com.bachue.snr.se.libraries.cacheCoherence;

import com.bachue.snr.se.libraries.shared.persistence.model.Usuario;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

public class UsuarioCache {

	NamedCache cache = CacheFactory.getCache("UserCache");
	
	public Usuario getUserCache(String key) {
		Usuario user = (Usuario) cache.get (key);
		return user;
	}
}
