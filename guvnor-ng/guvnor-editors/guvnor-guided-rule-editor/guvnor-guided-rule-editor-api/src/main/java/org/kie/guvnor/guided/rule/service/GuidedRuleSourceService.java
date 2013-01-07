/*
 * Copyright 2013 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.guvnor.guided.rule.service;

import org.kie.commons.java.nio.file.Path;
import org.kie.guvnor.commons.service.source.SourceService;
import org.uberfire.backend.server.util.Paths;

import javax.inject.Inject;

public class GuidedRuleSourceService
        implements SourceService {

    @Inject
    private GuidedRuleEditorService guidedRuleEditorService;

    @Inject
    Paths paths;

    @Override
    public String getSupportedFileExtension() {
        return ".brl";
    }

    @Override
    public String getSource(Path path) {
        return guidedRuleEditorService.toSource(guidedRuleEditorService.loadRuleModel(paths.convert(path)));
    }
}
