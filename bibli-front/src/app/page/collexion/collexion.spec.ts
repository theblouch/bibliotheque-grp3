import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Collexion } from './collexion';

describe('Collexion', () => {
  let component: Collexion;
  let fixture: ComponentFixture<Collexion>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Collexion]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Collexion);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
