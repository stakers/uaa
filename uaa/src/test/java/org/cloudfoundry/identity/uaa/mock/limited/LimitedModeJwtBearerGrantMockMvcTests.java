/*
 * ****************************************************************************
 *     Cloud Foundry
 *     Copyright (c) [2009-2017] Pivotal Software, Inc. All Rights Reserved.
 *
 *     This product is licensed to you under the Apache License, Version 2.0 (the "License").
 *     You may not use this product except in compliance with the License.
 *
 *     This product includes a number of subcomponents with
 *     separate copyright notices and license terms. Your use of these
 *     subcomponents is subject to the terms and conditions of the
 *     subcomponent's license, as noted in the LICENSE file.
 * ****************************************************************************
 */

package org.cloudfoundry.identity.uaa.mock.limited;

import org.cloudfoundry.identity.uaa.mock.token.JwtBearerGrantMockMvcTests;
import org.cloudfoundry.identity.uaa.web.LimitedModeUaaFilter;
import org.junit.After;
import org.junit.Before;

public class LimitedModeJwtBearerGrantMockMvcTests extends JwtBearerGrantMockMvcTests {
    private boolean original;

    @Before
    public void setup () throws Exception {
        LimitedModeUaaFilter bean = getWebApplicationContext().getBean(LimitedModeUaaFilter.class);
        original = bean.isEnabled();
        bean.setEnabled(true);
    }

    @After
    public void teardown() throws Exception {
        getWebApplicationContext().getBean(LimitedModeUaaFilter.class).setEnabled(original);
    }
}
