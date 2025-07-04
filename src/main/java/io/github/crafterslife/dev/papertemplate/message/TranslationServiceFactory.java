/*
 * PaperTemplate
 *
 * Copyright (c) 2025. Namiu/うにたろう
 *                     Contributors []
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package io.github.crafterslife.dev.papertemplate.message;

import java.lang.reflect.Proxy;

/**
 * TranslationService のプロキシインスタンスを生成するファクトリ。
 */
@SuppressWarnings("unchecked")
public final class TranslationServiceFactory {

    private TranslationServiceFactory() {

    }

    /**
     * TranslationServiceのプロキシインスタンスを生成する。
     *
     * @param serviceInterface インターフェース
     * @param <T> インターフェースの型
     * @return プロキシインスタンス
     * @throws IllegalArgumentException インターフェースではない場合
     */
    public static <T> T create(final Class<T> serviceInterface) throws IllegalArgumentException {
        if (!serviceInterface.isInterface()) {
            throw new IllegalArgumentException("インターフェースではない: %s".formatted(serviceInterface.getName()));
        }

        return (T) Proxy.newProxyInstance(
            serviceInterface.getClassLoader(),
            new Class<?>[]{serviceInterface},
            new TranslationServiceHandler()
        );
    }
}
