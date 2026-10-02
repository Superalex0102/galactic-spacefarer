using GalacticService as service from '../../srv/galactic-service';
annotate service.SpaceFarers with @(
    UI.FieldGroup #GeneratedGroup : {
        $Type : 'UI.FieldGroupType',
        Data : [
            {
                $Type : 'UI.DataField',
                Label : 'name',
                Value : name,
            },
            {
                $Type : 'UI.DataField',
                Label : 'email',
                Value : email,
            },
            {
                $Type : 'UI.DataField',
                Label : 'starductCollection',
                Value : starductCollection,
            },
            {
                $Type : 'UI.DataField',
                Label : 'wormholeNavigationSkill',
                Value : wormholeNavigationSkill,
            },
            {
                $Type : 'UI.DataField',
                Label : 'spaceSuitColor',
                Value : spaceSuitColor,
            },
        ],
    },
    UI.Facets : [
    {
        $Type : 'UI.ReferenceFacet',
        ID : 'GeneratedFacet1',
        Label : 'General Information',
        Target : '@UI.FieldGroup#GeneratedGroup',
    },
    {
        $Type : 'UI.ReferenceFacet',
        ID : 'EditableDetailsFacet',
        Label : 'Spacefarer Details',
        Target : '@UI.FieldGroup#EditableDetails',
    },
],
    UI.LineItem : [
        {
            $Type : 'UI.DataField',
            Label : 'name',
            Value : name,
        },
        {
            $Type : 'UI.DataField',
            Label : 'email',
            Value : email,
        },
        {
            $Type : 'UI.DataField',
            Label : 'starductCollection',
            Value : starductCollection,
        },
        {
            $Type : 'UI.DataField',
            Label : 'wormholeNavigationSkill',
            Value : wormholeNavigationSkill,
        },
        {
            $Type : 'UI.DataField',
            Label : 'spaceSuitColor',
            Value : spaceSuitColor,
        },
    ],
    UI.FieldGroup #EditableDetails : {
        $Type : 'UI.FieldGroupType',
        Data : [
            {
                $Type : 'UI.DataField',
                Label : 'Stardust collection',
                Value : starductCollection,
            },
            {
                $Type : 'UI.DataField',
                Label : 'Wormhole navigation skill',
                Value : wormholeNavigationSkill,
            },
            {
                $Type : 'UI.DataField',
                Label : 'Spacesuit color',
                Value : spaceSuitColor,
            }
        ]
    },
);

