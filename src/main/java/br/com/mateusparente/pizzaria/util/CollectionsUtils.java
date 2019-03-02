package br.com.mateusparente.pizzaria.util;

import java.util.Collection;
import java.util.Collections;

/**
 * @author mateusparente
 */
public class CollectionsUtils {

	public static <E> boolean listaEhValida(Collection<E> collection){
		return collection != null && !collection.isEmpty();
	}
	
	public static <T> Collection<T> defaultList(Collection<T> collection){
		if(collection == null)
			return Collections.emptyList();
		return collection;
	}
	
}