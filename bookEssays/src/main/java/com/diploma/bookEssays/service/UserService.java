package com.diploma.bookEssays.service;

import com.diploma.bookEssays.entity.user.User;

import java.util.List;

public interface UserService {
    /**
     * Ищет пользователя по логину
     *
     * @param username логин пользователя
     * @return Optional передаваемых данных пользователя
     */
    User getByUsername(String username);

    /**
     * Получение данных пользователя по индефикатору
     *
     * @param id индефикатор пользователя
     * @return передаваемые данные пользователя
     */
    User getById(Long id);

    /**
     * Получаем список пользователей
     *
     * @return список пользователей
     */
    List<User> findAllUsers();


    /**
     *Обновление информации пользователя
     *
     * @param user пользователь
     * @return пользователь обнавленный
     */
    User updateUser(User user);

    /**
     *Удаление пользователя
     *
     * @param id индификатор пользователя
     */
    void deleteUser(Long id);

    /**
     *Создание нового пользователя
     *
     * @param user пользователь
     */
    boolean createUser(User user);

    /**
     *Определение зависимости
     *
     * @param userId индификатор пользователя
     * @param memoId индификатор конспекта
     * @return возвращает ответ о зависимости
     */
    boolean isMemoOwner(Long userId, Long memoId);

}
