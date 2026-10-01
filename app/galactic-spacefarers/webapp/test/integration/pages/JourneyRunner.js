sap.ui.define([
    "sap/fe/test/JourneyRunner",
	"galacticspacefarers/test/integration/pages/SpaceFarersList.gen",
	"galacticspacefarers/test/integration/pages/SpaceFarersObjectPage.gen"
], function (JourneyRunner, SpaceFarersListGenerated, SpaceFarersObjectPageGenerated) {
    'use strict';

    const runner = new JourneyRunner({
        launchUrl: sap.ui.require.toUrl('galacticspacefarers') + '/test/flpSandbox.html#galacticspacefarers-tile',
        pages: {
			onTheSpaceFarersListGenerated: SpaceFarersListGenerated,
			onTheSpaceFarersObjectPageGenerated: SpaceFarersObjectPageGenerated
        },
        async: true
    });

    return runner;
});

