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
);

