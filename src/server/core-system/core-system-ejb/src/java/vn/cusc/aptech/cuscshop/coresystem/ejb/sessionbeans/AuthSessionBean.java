/*
 * The MIT License
 *
 * Copyright 2021 Daomtthuan.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package vn.cusc.aptech.cuscshop.coresystem.ejb.sessionbeans;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.mindrot.jbcrypt.BCrypt;
import vn.cusc.aptech.cuscshop.coresystem.ejb.entities.Account;
import vn.cusc.aptech.cuscshop.coresystem.ejb.facades.AccountFacadeLocal;

/**
 * Auth session bean
 *
 * @author Daomtthuan
 * @version 1.0
 */
@Stateless
public class AuthSessionBean implements AuthSessionBeanLocal {

    @EJB
    private AccountFacadeLocal accountFacade;

    @Override
    public Account authenticateLocal(String username, String password) {
        Account account = accountFacade.findByUsername(username);
        if (account != null) {
            if (BCrypt.checkpw(password, account.getPassword())) {
                return account;
            }
        }
        return null;
    }

}
