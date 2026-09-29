using {galactic} from '../db/data-models';

@requires: 'authenticated-user'
service GalacticService {
    @restrict: [{ grant: '*', where: 'planet_ID = $user.planetId' }]
    entity SpaceFarers as projection on galactic.SpaceFarer;
}
