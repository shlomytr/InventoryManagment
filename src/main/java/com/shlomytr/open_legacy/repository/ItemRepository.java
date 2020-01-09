package com.shlomytr.open_legacy.repository;

import com.shlomytr.open_legacy.model.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository <ItemModel, Integer> {
}
