package com.fadelJmartPK.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fadelJmartPK.dbjson.JsonTable;
import com.fadelJmartPK.dbjson.Serializable;

public interface BasicGetController<T extends Serializable> {
	@SuppressWarnings("unchecked")
	@RequestMapping("/{id}")
	default Serializable getById(@PathVariable int id) {
		return (T) getJsonTable().get(id);
	}
	public abstract JsonTable<T> getJsonTable();
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/page")
	public default List<T> getPage(@PathVariable int page, @PathVariable int pageSize) {
		return getJsonTable().subList(page, pageSize);
	}
}
